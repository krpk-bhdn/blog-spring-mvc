<#import "parts/common.ftl" as c>

<@c.page>
    <form action="/users" method="post">
        <input type="hidden" name="userId" value="${author.id}">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div class="form-group">
            <label for="exampleInputEmail1">Username</label>
            <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                   name="username" value="${author.username}" placeholder="Username">
        </div>
        <#list roles as role>
            <div class="form-group form-check">
                <label><input type="checkbox" class="form-check-input" name="${role}"
                ${author.roles?seq_contains(role)?string("checked", "")}>${role}</label>
            </div>
        </#list>

        <button type="submit" class="btn btn-dark">Change</button>
    </form>
</@c.page>