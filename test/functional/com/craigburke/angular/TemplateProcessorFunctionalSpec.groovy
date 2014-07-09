package com.craigburke.angular

import geb.spock.GebReportingSpec
import spock.lang.Unroll

class TemplateProcessorFunctionalSpec extends GebReportingSpec {

    @Unroll("load template: #template")
    def "load a page with a directive"() {
        when:
        to DirectiveTestPage

        and:
        templateSelect = template

        then:
        waitFor {
            pageTitle == title
            directiveText == "I'm a directive!"
        }

        and:

        where:
        template        || title
        'test1.html'    || "Test1"
        'test2.html'    || "Test2"
        'test3.html'    || "Test3"
        'test4.html'    || "Test4"
    }


    def "field plugin integration"() {
        when:
        to FieldsTestPage

        and:
        name = "Foo"
        number = "33"

        then:
        nameValue == "Foo"
        numberValue == "33"
    }

}