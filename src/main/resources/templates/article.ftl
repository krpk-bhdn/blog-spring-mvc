<#import "parts/common.ftl" as c>

<@c.page>
    <div class="article">
        <h5 class="card-title">${article.title}</h5>
        <div class="d-flex justify-content-between card-text">
            <small class="text-muted">${article.author.username}</small>
            <small class="text-muted">${article.formatedPublicationDate()}</small>
        </div>
        <img src="/img/${article.filename}" class="card-img-top mt-3">
        <p class="card-text mt-5">${article.text}</p>
    </div>
</@c.page>