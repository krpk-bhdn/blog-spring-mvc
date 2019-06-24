<#macro comments article>
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
    <div>
        <#list article.comments as comment>
            <div class="media mt-5">
                <img src="/img/00132c15-0830-4851-8f70-c14c801c0beb.Screenshot from 2019-06-10 00-11-49.png"
                     class="rounded-circle mr-3" alt="...">
                <div class="media-body">
                    <h5 class="mt-0">${comment.user.username}</h5>
                    <div>
                        ${comment.text}
                    </div>
                    <button onclick="answer(${article.id}, ${comment.id})" class="btn btn-dark">Answer</button>
                    <p id="${comment.id}"></p>
                    <#list comment.subComments as subcomment>
                        <div class="media mt-3">
                            <a class="mr-3" href="#">
                                <img class="rounded-circle" src="/img/0e975483-af18-4286-b7b9-e78035d5a6bb.zdaniya_neboskreby_vid_snizu_nebo_118887_1920x1080.jpg" class="mr-3" alt="...">
                            </a>
                            <div class="media-body">
                                <h5 class="mt-0">${subcomment.user.username}</h5>
                                <div>
                                    ${subcomment.text}
                                </div>
                            </div>
                        </div>
                    </#list>
                </div>
            </div>
        </#list>
    </div>


</#macro>