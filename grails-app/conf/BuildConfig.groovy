grails.project.work.dir = 'target'

grails.project.dependency.resolution = {
    inherits "global"
    log "warn"
    if(grailsVersion >= '2.1.3') {
        legacyResolve true // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility
    }
    repositories {
        grailsCentral()
    }
    plugins {
        build(":release:2.2.0",
              ":rest-client-builder:1.0.3") {
            export = false
        }
    }
}
