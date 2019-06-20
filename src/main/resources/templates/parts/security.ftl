<#assign
know = Session.SPRING_SECURITY_CONTEXT??
>
<#if know>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getUsername()
    isAdmin = user.isAdmin()
    isModerator = user.isModerator()
    >
<#else>
    <#assign
    name = "unknow"
    isAdmin = false
    isModerator = false
    >
</#if>