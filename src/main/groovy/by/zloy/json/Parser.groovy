package by.zloy.json

import groovy.json.JsonSlurper

class Parser {
    public static void main(String[] args) {
        String from = new File('/Users/eugene/workspace/zloy/zete/src/main/groovy/by/zloy/json/postman.json').text
        File to = new File('/Users/eugene/workspace/zloy/zete/src/main/groovy/by/zloy/json/postman-changed.json')

        parse(from, to)

//        String test = new File('/Users/eugene/workspace/zloy/zete/src/main/groovy/by/zloy/json/test.json').text
//        File testTo = new File('/Users/eugene/workspace/zloy/zete/src/main/groovy/by/zloy/json/testOneString.json')
//        rmSlashN(test, testTo)
    }

    static void rmSlashN(String from, File test) {
        test << from.replaceAll('\n', '')
    }

    static void parse(from, File to) {
        def jsonSlurper = new JsonSlurper()

        Map map = jsonSlurper.parseText(from)

        map.requests.each {
            String template = """
            {
                "id": "${it.id}",
                "lastModified": "2015-02-16T14:06:24.690+03:00",
                "name": "${it.name}",
                "headers": [
                    {
                        "enabled": true,
                        "name": "Authorization",
                        "value": "${it.headers.empty ? "" : it.headers.substring(15, 54)}"
                    }
                ],
                "method": {
                    "requestBody": true,
                    "link": "http://www.w3.org/Protocols/rfc2616/rfc2616-sec9.html#sec9.5",
                    "name": "${it.method}"
                },
                "body": {
                    "autoSetLength": true,
                    "textBody": "${
                it.rawModeData?.replaceAll('"', '\'')?.replaceAll('\n', '')?.replaceAll(' ', '')?.replaceAll('\t', '')
            }",
                    "bodyType": "Text"
                },
                "headersType": "Form",
                "type": "Request",
                "uri": {
                    "path": "${it.url.substring(7)}",
                    "scheme": {
                        "name": "http",
                        "version": "V11"
                    }
                },
                "parentId": "8A5D0768-DD73-4C7E-8024-0B073235E2C7"
            }
            """

            to << template
            to << ","
        }
    }

}
