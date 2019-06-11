<#import "parts/common.ftl" as c>

<@c.page>
    <form method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="exampleFormControlInput1">Title</label>
            <input type="text" class="form-control" id="exampleFormControlInput1" name="title" placeholder="Title">
        </div>
        <div class="form-group">
            <label for="exampleFormControlTextarea1">Text article</label>
            <textarea class="form-control" id="exampleFormControlTextarea1" name="text" rows="15"></textarea>
        </div>
        <div class="form-group">
            <label for="exampleFormControlFile1">Select image</label>
            <input type="file" class="form-control-file" id="exampleFormControlFile1" name="file">
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div class="form-group">
            <button class="btn btn-primary pa-3 ml-2" type="submit">Add article</button>
        </div>
    </form>
</@c.page>