<#import "parts/common.ftl" as c>
<#import "parts/navEditor.ftl" as nav>

<@c.page>

    <@nav.navEdit/>

    <table class="table mt-3">
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Title</th>
            <th scope="col">Author</th>
            <th scope="col">Verify</th>
            <th scope="col"></th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#list articles  as article>
            <tr>
                <th scope="row">${article.id}</th>
                <td>${article.title}</td>
                <td>${article.author.username}</td>
                <td>
                    <#if article.verify>
                        +
                    <#else >
                        -
                    </#if>
                </td>
                <td><a href="/editor/edit/${article.id}">Edit</a></td>
                <td><a class="text-danger" href="/editor/delete/${article.id}">Delete</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>

