package com.demo

class DemoController {

    def stuffService
    
    def index() { 
        redirect action: 'getValue'
    }
    
    def setValue(int i) {
        stuffService.setSomeValue(i)
        render 'set worked'
    }
    
    def getValue() {
        def x = stuffService.getSomeValue()
        
        render "Value is ${x}"
    }
    
    def clearCache() {
        stuffService.clearTheCache()
        render 'clearCache worked'
    }
}
