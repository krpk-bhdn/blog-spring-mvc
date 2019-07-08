<#import "parts/common.ftl" as c>

<@c.page>

    <nav class="nav nav-pills nav-fill mb-3">
        <a class="nav-item nav-link text-light bg-dark rounded-0" href="/moderation">
            Articles
        </a>
        <a class="nav-item nav-link text-dark bg-light rounded-0" href="/moderation/question">
            Questions
        </a>
    </nav>

    <#if !articles?has_content>
        <h3>No articles for verify</h3>
    <#else >
        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Title</th>
                <th scope="col">Username</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <#list articles as article>
                <tr>
                    <th scope="row">${article.id}</th>
                    <td>${article.title[0..*100]}</td>
                    <td>${article.author.username}</td>
                    <td>
                        <a href="/article/${article.id}">Review</a>
                        <a href="/moderation/confirm/${article.id}">Confirm</a>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    </#if>
</@c.page>