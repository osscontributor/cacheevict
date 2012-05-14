package com.demo

import grails.plugin.cache.CacheEvict
import grails.plugin.cache.Cacheable

class StuffService {

    private int someNumber = 42
    
    @CacheEvict(value='foo')
    def clearTheCache() {
    }
    
    @Cacheable(value='foo')
    def getSomeValue() {
        someNumber
    }
    
    def setSomeValue(int i) {
        someNumber = i
    }
}
