grails-glyph-icons
==================

A simple plugin that bundles free icons from http://glyphicons.com and provides a handful of convenient taglibs that create asynchronous buttons out of the icons.

# Icons
The icons themselves are located in the plugin's web-app/images directory, bundled exactly as they would be unzipped had you downloaded the zip file directly from GLYPHICONS. The free bundle includes the base set and a handful of social icons, located in images/glyphicons and images/glyphicons_social respectively.

## Designating An Icon
The plugin takes care of most of the excessive typing for you, allowing you to include ONLY the main part of the filename and not the extension. For example, the icon with the /images/glyphicons/png/glyphicons_000_glass.png path would require iconName="glyphicons_000_glass". Future versions may take it a step further, removing the initial 'glyphicons_000_' portion.

## Context
The Context merely designates the 'set' of icons you wish to use, currently only 'glyphicons' and 'social'. The GLYPHICONS release distributes the 'glyphicons' set of icons and the 'social' set of icons.

## Icon Type
GLYPHICONS offers a paid version of their icons, which provides a nice variety of image types. The free version includes only PNG files, though.

#Taglib
## glyph:icon
Generates an `<img/>` tag that will load the icon on the page.

For example, the following will produce an <img/> tag on the page, loading the glyphicons_001_leaf.png icon:
    `<glyph:icon iconName="glyphicons_001_leaf"/>`

### iconName
The file name of the plugin without the .png extension. For example, `iconName="glyphicons_005_car"` would load the resource from /images/glyphicons/png/glyphicons_005_car.png.
### context
Currently either 'social' or 'glyphicons'. Context is optional and will default to 'glyphicons'
### alt
Creates the HTML alt attribute in the `<img/>` tag. The taglib doesn't require this attribute, although HTML standard does. If you leave this blank, the plugin will place the iconName in there instead.
### width
Generates an HTML width attribute in the `<img/>` tag.
### height
Generates an HTML height attribute in the `<img/>` tag.

## glyph:action
Uses an icon as a link to a remote uri that can be invoked via ajax. This tag is a thin wrapper above the remoteLink tag built into grails. The attributes for the action tag are exactly the same as icon, adding all the attributes from remoteLink.

For example, the following will produce an async link using the the glyphicons_001_leaf.png icon, calling the mycontroller/list and updating the content element with the results:
`<glyph:action controller="mycontroller" action="list" update="content" iconName="glyphicons_001_leaf" alt="Leaf Icon" />`

Given the action tag leverages the remoteLink tag, here are some examples taken from http://grails.org/doc/latest/ref/Tags/remoteLink.html redone for glyph:

`<glyph:action iconName="glyphicons_001_leaf" alt="Leaf Icon" action="show" id="1">Test 1</glyph:action>`
`<glyph:action iconName="glyphicons_001_leaf" alt="Leaf Icon" action="show" id="1"
update="[success:'success',failure:'error']" on404="alert('not found');">Test 2</glyph:action>`
`<glyph:action iconName="glyphicons_001_leaf" alt="Leaf Icon" action="show" id="1"
update="success" onLoading="showSpinner();">Test 3</glyph:action>`
`<glyph:action iconName="glyphicons_001_leaf" alt="Leaf Icon" action="show" id="1"
update="success" params="[sortBy:'name',offset:offset]">Test 4</glyph:action>`
`<glyph:action iconName="glyphicons_001_leaf" alt="Leaf Icon" action="show" id="1"
update="success" before="if(!confirm('Are you sure?')) return false">Test 5</glyph:action>`
