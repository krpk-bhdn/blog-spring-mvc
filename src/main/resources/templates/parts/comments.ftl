<#macro comments article isKnow>
    <#if isKnow>
        <div>
            <form class="mt-5" action="/article/${article.id}/addComment" method="post">
                <input type="hidden" id="csrf" name="_csrf" value="${_csrf.token}">
                <div class="form-group">
                    <label for="exampleFormControlTextarea1">Comment:</label>
                    <textarea class="form-control" id="exampleFormControlTextarea1" name="text" rows="3"></textarea>
                </div>

                <button type="submit" class="btn btn-dark">Submit</button>
            </form>
        </div>
    </#if>
    <div>
        <#list article.comments?sort_by("publicationDate")?reverse as comment>
            <div class="media mt-5">
                <img src="/img/${comment.author.filename}"
                     class="rounded-circle mr-3" alt="...">
                <div class="media-body">
                    <h5 class="mt-0 <#if comment.author.admin || comment.author.moderator>name-adm-mod</#if>">${comment.author.username}</h5>
                    <div>
                        ${comment.text}
                        <p class="m-0"><small class="text-muted">${comment.formattedPublicationDate()}</small></p>
                    </div>
                    <#if isKnow>
                        <button onclick="answer(${article.id}, ${comment.id})" class="btn btn-dark mt-1">Answer</button>
                    </#if>
                    <p id="${comment.id}"></p>
                    <#list comment.subComments?sort_by("publicationDate")?reverse as subcomment>
                        <div class="media mt-3">
                            <a class="mr-3" href="#">
                                <img class="rounded-circle" src="/img/${subcomment.author.filename}" class="mr-3" alt="...">
                            </a>
                            <div class="media-body">
                                <h5 class="mt-0 <#if subcomment.author.admin || subcomment.author.moderator>name-adm-mod</#if>">${subcomment.author.username}</h5>
                                <div>
                                    ${subcomment.text}
                                    <p class="m-0"><small class="text-muted">${subcomment.formattedPublicationDate()}</small></p>
                                </div>
                            </div>
                        </div>
                    </#list>
                </div>
            </div>
        </#list>
    </div>


</#macro>