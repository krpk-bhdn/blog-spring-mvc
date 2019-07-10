<#macro article article isConfirm>
    <div class="article">
        <h5 class="card-title">${article.title}</h5>
        <div class="d-flex justify-content-between card-text">
            <small class="text-muted">${article.author.username}</small>
            <small class="text-muted">${article.formattedPublicationDate()}</small>
        </div>
        <div class="text-center"><img src="/img/${article.filename}" class="img-fluid mt-3"></div>
        <p class="card-text mt-5">${article.text}</p>
    </div>
    <#if isConfirm>
        <a class="btn btn-dark" href="/moderation/confirm/${article.id}">Confirm</a>
    </#if>
</#macro>