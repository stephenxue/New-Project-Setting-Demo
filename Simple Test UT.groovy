package test.com

import com.sap.gateway.ip.core.customdev.util.Message
import com.sap.gateway.ip.core.customdev.processor.MessageImpl

GroovyShell shell = new GroovyShell()
def script = shell.parse(new File("Simple Test.groovy"))

String testJSON = new File('test.json').getText('UTF-8')

Message msg = new MessageImpl()
msg.setBody(testJSON)
msg.setHeader('Content-Type', 'application/json')

script.processData(msg)
println  msg.getBody()
