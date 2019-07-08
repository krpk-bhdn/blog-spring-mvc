<#macro editor isEdit=false isQuestion=false item=.data_model>

    <form class="mt-3" method="post"
          action="
                <#if !isEdit && !isQuestion>
                    /editor/add
                <#elseif !isEdit && isQuestion>
                    /editor/question/add
                <#elseif isEdit && !isQuestion>
                    /editor/edit/${item.id}
                <#elseif isEdit && isQuestion>
                    /editor/question/edit/${item.id}
                </#if>
                "
          enctype="multipart/form-data">

        <div class="form-group">
            <label for="exampleFormControlInput1">Title</label>
            <input type="text" class="form-control" id="exampleFormControlInput1" name="title" placeholder="Title"
                    <#if isEdit> value="${item.title}" </#if>
            >
        </div>
        <#if isQuestion && !isEdit>
            <div class="form-group">
                <label>Select category:</label>
                <div class="form-check">
                    <label><input type="radio" class="form-check-input" name="category" value="DISCUSSION" checked>
                        Discussion
                    </label>
                </div>
                <div class="form-check">
                    <label><input type="radio" class="form-check-input" name="category" value="SUPPORT">
                        Support
                    </label>
                </div>
            </div>
        </#if>
        <div class="form-group">
            <label for="exampleFormControlTextarea1">Text <#if !isQuestion>article<#else>question</#if></label>
            <textarea class="form-control" id="exampleFormControlTextarea1" name="text" rows="15">
                <#if isEdit> ${item.text} </#if>
            </textarea>
        </div>
        <#if !isQuestion && !isEdit>
            <div class="form-group">
                <label for="exampleFormControlFile1">Select image</label>
                <input type="file" class="form-control-file" id="exampleFormControlFile1" name="file">
            </div>
        </#if>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div class="form-group">
            <button class="btn btn-dark pa-3 ml-2" type="submit">Add <#if !isQuestion>article<#else>question</#if></button>
        </div>
    </form>

</#macro>