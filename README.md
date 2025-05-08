# import org.openqa.selenium.chrome.ChromeOptions
import com.kms.katalon.core.webui.driver.DriverFactory

ChromeOptions options = new ChromeOptions()
options.addArguments("--disable-notifications")

DriverFactory.changeWebDriver(new ChromeDriver(options)

Go to Project > Settings > Execution > Default > Web UI > Chrome.
	2.	Click Add and create the following key-value pair:
	•	Name: prefs
	•	Type: Dictionary
	•	Value: (click the ellipsis ... to open the dictionary editor)
Inside the dictionary editor, add:
Key
Type
Value
profile.default_content_setting_values.notifications
Number
2


Test Failures Due to Environment Switch – Fix Estimation

Dear Stakeholders,

The existing automation test cases were originally designed to run against the Stage environment, with data and object locators tailored accordingly. Upon executing the same suite in the Test environment as requested, we have encountered several test failures due to environment-specific differences.

We are currently analyzing the failures and estimating approximately [insert estimated time, e.g., 2–3 working days] to refactor the scripts and resolve the issues for Test environment compatibility.

I will keep you updated on the progress and inform you once the suite is stable and ready for execution in Test.


import javax.mail.*
import javax.mail.search.FlagTerm
import javax.mail.internet.MimeMultipart
import java.util.Properties
import java.time.Duration
import java.util.function.Function
import org.openqa.selenium.support.ui.FluentWait

// Email credentials
String host = "outlook.office365.com"
String username = "your_email@outlook.com"
String password = "your_app_password" // App Password if MFA is enabled

String getTextFromMessage(Message message) {
    if (message.isMimeType("text/plain")) {
        return message.getContent().toString()
    } else if (message.isMimeType("multipart/*")) {
        MimeMultipart mimeMultipart = (MimeMultipart) message.getContent()
        for (int i = 0; i < mimeMultipart.getCount(); i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i)
            if (bodyPart.isMimeType("text/plain")) {
                return bodyPart.getContent().toString()
            }
        }
    }
    return ""
}

String extractOtp(String text) {
    def matcher = text =~ /\b\d{6}\b/ // Adjust if OTP pattern is different
    return matcher ? matcher[0] : null
}

String waitForUnreadOtpEmail() {
    Properties props = new Properties()
    props.put("mail.store.protocol", "imap")
    props.put("mail.imap.host", host)
    props.put("mail.imap.port", "993")
    props.put("mail.imap.ssl.enable", "true")

    Session session = Session.getDefaultInstance(props)
    Store store = session.getStore("imap")
    store.connect(username, password)

    Folder inbox = store.getFolder("INBOX")
    inbox.open(Folder.READ_WRITE) // Marking email as read requires READ_WRITE

    // Fluent wait: max 90s, poll every 5s
    FluentWait wait = new FluentWait(null)
            .withTimeout(Duration.ofSeconds(90))
            .pollingEvery(Duration.ofSeconds(5))
            .ignoring(Exception.class)

    String otp = wait.until(new Function<Object, String>() {
        @Override
        String apply(Object input) {
            // Search only UNSEEN messages
            Message[] unreadMessages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false))

            for (int i = unreadMessages.length - 1; i >= 0; i--) {
                Message message = unreadMessages[i]
                if (message.getSubject().toLowerCase().contains("otp")) {
                    String body = getTextFromMessage(message)
                    String foundOtp = extractOtp(body)
                    if (foundOtp != null) {
                        // Mark email as read
                        message.setFlag(Flags.Flag.SEEN, true)
                        return foundOtp
                    }
                }
            }
            println("Waiting for unread OTP email...")
            return null
        }
    })

    inbox.close(false)
    store.close()
    return otp
}

// Usage
String otp = waitForUnreadOtpEmail()
WebUI.setText(findTestObject('Page_Login/input_otp'), otp)
WebUI.click(findTestObject('Page_Login/btn_submit'))