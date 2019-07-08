<#import "parts/common.ftl" as c>
<#import "parts/navEditor.ftl" as nav>
<#import "parts/editor.ftl" as editor>

<@c.page>

    <@nav.navEdit isQuestion=true isAdd=true/>
    <@editor.editor isQuestion=true/>

</@c.page>