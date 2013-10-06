package com.lce.atg.grails.plugin

class GlyphIconsPluginTagLib {

    static namespace = "glyph"

    /**
     * Generates an HTML img tag that will load the icon on the page.
     *
     * @attr iconName The file name of the plugin without the .png extension
     * @attr context Currently either 'social' or 'glyphicons'. Context is optional and will default to 'glyphicons'
     * @attr alt Creates the HTML alt attribute in the <img/> tag. The taglib doesn't require this attribute, although HTML standard does. If you leave this blank, the plugin will place the iconName in there instead.
     * @attr width Generates an HTML width attribute in the <img/> tag.
     * @attr height Generates an HTML height attribute in the <img/> tag.
     */
    def icon = { attr ->
        out << buildImageMarkup(attr)
    }

    /**
     * Uses an icon as a link to a remote uri that can be invoked via ajax. This tag is a thin wrapper above
     * the remoteLink tag built into grails.
     *
     * @attr iconName The file name of the plugin without the .png extension
     * @attr context Currently either 'social' or 'glyphicons'. Context is optional and will default to 'glyphicons'
     * @attr alt Creates the HTML alt attribute in the <img/> tag. The taglib doesn't require this attribute, although HTML standard does. If you leave this blank, the plugin will place the iconName in there instead.
     * @attr width Generates an HTML width attribute in the <img/> tag.
     * @attr height Generates an HTML height attribute in the <img/> tag.
     * @attr update Either a map containing the elements to update for 'success' or 'failure' states, or a string with the element to update in which cause failure events would be ignored
     * @attr before The javascript function to call before the remote function call
     * @attr after The javascript function to call after the remote function call
     * @attr asynchronous Whether to do the call asynchronously or not (defaults to true)
     * @attr method The method to use the execute the call (defaults to "post")
     * @attr controller The name of the controller to use in the link, if not specified the current controller will be linked
     * @attr action The name of the action to use in the link, if not specified the default action will be linked
     * @attr uri relative URI
     * @attr url A map containing the action,controller,id etc.
     * @attr base Sets the prefix to be added to the link target address, typically an absolute server URL. This overrides the behaviour of the absolute property, if both are specified.
     * @attr absolute If set to "true" will prefix the link target address with the value of the grails.serverURL property from Config, or http://localhost:&lt;port&gt; if no value in Config and not running in production.
     * @attr id The id to use in the link
     * @attr fragment The link fragment (often called anchor tag) to use
     * @attr params A map containing URL query parameters
     * @attr mapping The named URL mapping to use to rewrite the link
     * @attr elementId the DOM element id
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

        StringBuilder buffer = new StringBuilder()
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
