<#import "parts/common.ftl" as c>

<@c.page>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Username</th>
            <th scope="col">Roles</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <th scope="row">${user.id}</th>
                <td>${user.username}</td>
                <td><#list user.roles as role>${role}<#sep >, </#list></td>
                <td><a href="/users/${user.id}">Edit</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>