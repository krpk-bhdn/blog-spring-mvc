<#import "parts/common.ftl" as c>
<#import "parts/article.ftl" as a>
<@c.page>
    <@a.article article=article isConfirm=!article.isVerify()/>
</@c.page>