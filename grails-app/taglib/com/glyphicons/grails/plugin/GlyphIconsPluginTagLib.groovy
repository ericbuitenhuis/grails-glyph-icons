package com.glyphicons.grails.plugin

import groovy.xml.MarkupBuilder

class GlyphIconsPluginTagLib {

    static namespace = "glyph"

    def icon = { attr ->
        out << buildImageMarkup(attr)
    }

    /**
     * <a href="http://www.pageresource.com">
     *     <img src="next.jpg" />
     * </a>
     */
    def action = { attr ->
        def bodyString = buildImageMarkup(attr)

        attr.remove('iconName')
        attr.remove('context')
        attr.remove('alt')
        attr.remove('width')
        attr.remove('height')

        out << remoteLink(attr, bodyString)
    }

    private String buildImageMarkup(Map attr) {

        def context = attr.context ?: "glyphicons"
        def dir = '/images/' + context + '/png'
        def link = resource(dir: dir, file: attr.iconName + '.png', plugin: 'glyphicons')
        def alt = attr.alt ?: attr.name


        StringBuffer buffer = new StringBuffer()
        buffer.append('<img ')
        buffer.append('src="').append(link).append('" ')
        buffer.append('alt="').append(alt).append('" ')
        if (attr.height) {
            buffer.append('height="').append(attr.height).append('" ')
        }
        if (attr.width) {
            buffer.append('width="').append(attr.width).append('" ')
        }
        buffer.append("/>")
    }

}
