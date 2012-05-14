package com.demo

class PersonFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    
    void testPersonCacheEviction() {
        get '/person/create'
        form {
            firstName = 'original first name'
            lastName = 'original last name'
            click 'create'
        }
        assertTitle 'Show Person'
        assertContentContains 'original first name'
        assertContentContains 'original last name'
        
        click 'Edit'
        form {
            firstName = 'updated first name'
            click '_action_update'
        }
        assertTitle 'Show Person'
        assertContentContains 'original first name'
        assertContentContains 'original last name'

        click 'here to clear the cache'
        
        assertTitle 'Show Person'
        assertContentContains 'updated first name'
        assertContentContains 'original last name'
    }
}
