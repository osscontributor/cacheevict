package com.demo

class DemoFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    
    void testCacheEviction() {
        // set the value to 42
        get '/demo/setValue?i=42'
        assertStatus 200
        assertContentContains 'set worked'

        // retrieve the value, should be 42
        get '/demo/getValue'
        assertStatus 200
        assertContentContains 'Value is 42'

        // set the value to 2112
        get '/demo/setValue?i=2112'
        assertStatus 200
        assertContentContains 'set worked'

        // get the value, should still be 42 because 42 was cached
        get '/demo/getValue'
        assertStatus 200
        assertContentContains 'Value is 42'

        // clear the cache
        get '/demo/clearCache'
        assertStatus 200
        assertContentContains 'clearCache worked'
        
        // get the value, should be 2112 since the cache was cleared
        get '/demo/getValue'
        assertStatus 200
        assertContentContains 'Value is 2112'
    }
}