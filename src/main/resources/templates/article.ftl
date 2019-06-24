<#import "parts/common.ftl" as c>
<#import "parts/article.ftl" as a>
<#import "parts/comments.ftl" as com>

<#include "parts/security.ftl">

<@c.page>
    <@a.article article=article isConfirm=know && (isModerator || isAdmin) && !article.isVerify()/>
    <@com.comments article=article/>
</@c.page>