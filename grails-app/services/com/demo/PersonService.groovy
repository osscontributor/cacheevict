package com.demo

import grails.plugin.cache.CacheEvict
import grails.plugin.cache.Cacheable

class PersonService {

    @Cacheable('people')
    def loadPerson(id) {
        Person.get(id)
    }
    
    @CacheEvict(value='people', key='#id')
    void clearPeopleCache(id) {
    }
}
