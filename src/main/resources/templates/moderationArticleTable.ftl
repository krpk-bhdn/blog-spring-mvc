<#import "parts/common.ftl" as c>

<@c.page>
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