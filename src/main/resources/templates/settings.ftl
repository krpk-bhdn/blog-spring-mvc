<#import "parts/common.ftl" as c>

<@c.page>

    <div>
        <form action="/profile/settings/changeAvatar" method="post" enctype="multipart/form-data">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <div class="form-group">
                <div class="form-group">
                    <label for="exampleFormControlFile1">Select image</label>
                    <input type="file" class="form-control-file" id="exampleFormControlFile1" name="file">
                </div>
            </div>
            <button type="submit" class="btn btn-dark">Change avatar</button>
        </form>
    </div>

    <div class="mt-5">
        <form action="/profile/changeUsername" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <div class="form-group">
                <label for="exampleInputEmail1">Username</label>
                <input type="text" class="form-control" name="username" placeholder="Username" value="${user.username}">
                <small id="emailHelp" class="form-text text-muted">
                    Your username must be 6-24 characters long, contain letters and numbers, and must not contain spaces,
                    special characters, or emoji.
                </small>
            </div>
            <button type="submit" class="btn btn-dark">Change username</button>
        </form>
    </div>


    <div class="mt-5">
        <form action="/profile/changePassword" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <div class="form-group">
                <label for="inputPassword5">Password</label>
                <input type="password" id="inputPassword5" class="form-control" aria-describedby="passwordHelpBlock"
                       placeholder="Old password" name="oldPassword">
                <input type="password" id="inputPassword5" class="form-control mt-3" aria-describedby="passwordHelpBlock"
                       placeholder="New password" name="newPassword">
                <small id="passwordHelpBlock" class="form-text text-muted">
                    Your password must be 8-20 characters long, contain letters and numbers, and must not contain spaces,
                    special characters, or emoji.
                </small>
                <input type="password" id="inputPassword5" class="form-control mt-3" aria-describedby="passwordHelpBlock"
                       placeholder="Repeat new password">
            </div>
            <button type="submit" class="btn btn-dark">Change password</button>
        </form>
    </div>
</@c.page>