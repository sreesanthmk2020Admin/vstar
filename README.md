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


import javax.naming.*;
import javax.naming.directory.*;
import java.util.Hashtable;

public class GetWindowsDisplayName {
    public static void main(String[] args) {
        String username = System.getProperty("user.name"); // e.g., jdoe

        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://your.domain.controller"); // Replace with your domain controller
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "your_domain\\" + username); // e.g., CORP\\jdoe
        env.put(Context.SECURITY_CREDENTIALS, "your_password"); // Ideally use a secure method

        try {
            DirContext ctx = new InitialDirContext(env);
            String searchFilter = "(&(objectClass=user)(sAMAccountName=" + username + "))";
            String[] attrIDs = { "displayName" };

            SearchControls ctls = new SearchControls();
            ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            ctls.setReturningAttributes(attrIDs);

            NamingEnumeration<SearchResult> answer = ctx.search("DC=your,DC=domain,DC=com", searchFilter, ctls);

            if (answer.hasMore()) {
                Attributes attrs = answer.next().getAttributes();
                System.out.println("Display Name: " + attrs.get("displayName").get());
            } else {
                System.out.println("User not found.");
            }
            ctx.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}