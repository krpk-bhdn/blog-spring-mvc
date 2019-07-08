<#import "parts/common.ftl" as c>
<#import "parts/navEditor.ftl" as nav>

<@c.page>

    <@nav.navEdit isQuestion=true/>

    <table class="table mt-3">
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Title</th>
            <th scope="col">Author</th>
            <th scope="col">Category</th>
            <th scope="col">Verify</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#list questions as question>
            <tr>
                <th scope="row">${question.id}</th>
                <td>${question.title}</td>
                <td>${question.author.username}</td>
                <td><#list question.categories as category>${category}</#list></td>
                <td>
                    <#if question.verify>
                        +
                    <#else >
                        -
                    </#if>
                </td>
                <td><a href="/editor/question/edit/${question.id}">Edit</a></td>
                <td><a class="text-danger" href="/editor/question/delete/${question.id}">Delete</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>