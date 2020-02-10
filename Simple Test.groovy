package test.com

import com.sap.gateway.ip.core.customdev.util.Message;
import groovy.json.*;

Message processData(Message message) {
    def body = message.getBody( ) as String
    def jsonSlurper = new JsonSlurper()
    def jsonObject = jsonSlurper.parseText(body);
    jsonObject.content = jsonObject.content + ", Groovy."
    def result = JsonOutput.toJson(jsonObject)
    message.setBody(result);
    message.setHeader('Content-Type', 'application/json');
    return message
}
