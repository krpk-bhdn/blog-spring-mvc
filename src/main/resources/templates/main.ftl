<#import "parts/common.ftl" as c>

<@c.page>
    <div class="card-columns">
        <#list articles as article>
            <a class="article-link" href="/article/${article.id}">
                <div class="card">
                    <#if article.filename??>
                        <img src="/img/${article.filename}" class="card-img-top" alt="...">
                    </#if>
                    <div class="card-body">
                        <h5 class="card-title">${article.title[0..*50]}</h5>
                        <p class="card-text">${article.text[0..*155]}...</p>
                        <p class="card-text"><small class="text-muted">${article.formattedPublicationDate()}</small></p>
                    </div>
                </div>
            </a>
        </#list>
    </div>
</@c.page>