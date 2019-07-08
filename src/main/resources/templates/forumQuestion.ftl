<#import "parts/common.ftl" as c>
<#import "parts/forum.ftl" as f>
<#include "parts/security.ftl">

<@c.page>
    <@f.forum question=question isKnow=know/>
</@c.page>