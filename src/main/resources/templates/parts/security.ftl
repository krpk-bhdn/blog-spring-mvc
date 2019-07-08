<#assign
know = Session.SPRING_SECURITY_CONTEXT??
>
<#if know>
    <#assign
    author = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = author.getUsername()
    isAdmin = author.isAdmin()
    isModerator = author.isModerator()
    >
<#else>
    <#assign
    name = "unknow"
    isAdmin = false
    isModerator = false
    >
</#if>