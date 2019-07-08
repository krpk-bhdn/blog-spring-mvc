<#macro forum question isKnow>

    <ul class="list-unstyled">
        <li class="media">
            <img src="/img/${question.author.filename}" class="mr-3 rounded-circle" alt="...">
            <div class="media-body">
                <h5 class="mt-0 mb-1">${question.author.username}</h5>
                ${question.text}
                <p class="m-0"><small class="text-muted">${question.formattedPublicationDate()}</small></p>
            </div>
        </li>
        <#list question.answers?sort_by("publicationDate") as answer>
            <li class="media my-4">
                <img src="/img/${answer.author.filename}" class="mr-3 rounded-circle" alt="...">
                <div class="media-body">
                    <h5 class="mt-0 mb-1">${answer.author.username}</h5>
                    ${answer.text}
                    <p class="m-0"><small class="text-muted">${answer.formattedPublicationDate()}</small></p>
                </div>
            </li>
        </#list>
    </ul>

    <#if isKnow>
        <div>
            <form class="mt-5" method="post">
                <input type="hidden" id="csrf" name="_csrf" value="${_csrf.token}">
                <div class="form-group">
                    <label for="exampleFormControlTextarea1">Answer:</label>
                    <textarea class="form-control" id="exampleFormControlTextarea1" name="text" rows="3"></textarea>
                </div>

                <button type="submit" class="btn btn-dark">Submit</button>
            </form>
        </div>
    </#if>

</#macro>