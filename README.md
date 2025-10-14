TestObject scrollDiv = findTestObject('Page_Siebel/table_div')
WebElement div = WebUI.findWebElement(scrollDiv)

for (int i = 0; i < 10; i++) {
    WebUI.executeJavaScript('arguments[0].scrollTop += 200', Arrays.asList(div))
    WebUI.delay(1)
}
