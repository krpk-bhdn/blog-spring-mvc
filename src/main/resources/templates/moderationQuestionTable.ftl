<#import "parts/common.ftl" as c>

<@c.page>

    <nav class="nav nav-pills nav-fill mb-3">
        <a class="nav-item nav-link text-dark bg-light rounded-0" href="/moderation">
            Articles
        </a>
        <a class="nav-item nav-link text-light bg-dark rounded-0" href="/moderation/question">
            Questions
        </a>
    </nav>

    <#if !questions?has_content>
        <h3>No questions for verify</h3>
    <#else >
        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Title</th>
                <th scope="col">Username</th>
                <th scope="col">Category</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <#list questions as question>
                <tr>
                    <th scope="row">${question.id}</th>
                    <td>${question.title[0..*100]}</td>
                    <td>${question.author.username}</td>
                    <td><#list question.categories as category>${category.name()}</#list></td>
                    <td>
                        <a href="/forum/${question.id}">Review</a>
                        <a href="/moderation/question/confirm/${question.id}">Confirm</a>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    </#if>
</@c.page>