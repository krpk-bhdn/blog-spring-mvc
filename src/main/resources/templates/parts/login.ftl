<#macro login>
    <button type="button" class="btn btn-dark dropdown-toggle" id="dropdownMenuOffset" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" data-offset="10,20">
        Sign In
    </button>
    <div class="dropdown-menu dropdown-menu-right">
        <form class="px-4 py-3" action="/" method="post">
            <div class="form-group">
                <label for="exampleDropdownFormEmail1">Username</label>
                <input type="text" class="form-control" id="exampleDropdownFormEmail1" placeholder="Username" name="username">
            </div>
            <div class="form-group">
                <label for="exampleDropdownFormPassword1">Password</label>
                <input type="password" class="form-control" id="exampleDropdownFormPassword1" placeholder="Password" name="password">
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit" class="btn btn-dark">Sign in</button>
        </form>
        <div class="dropdown-divider"></div>
        <a class="dropdown-item" href="/registration">New around here? Sign up</a>
    </div>
</#macro>

<#macro registration>
    <form action="/registration" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">User Name:</label>
            <div class="col-sm-6">
                <input class="form-control" type="text" name="username" placeholder="User name"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Password:</label>
            <div class="col-sm-6">
                <input class="form-control" type="password" name="password" placeholder="Password"/>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit" class="btn btn-dark">Create</button>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit" class="dropdown-item">Sign Out</button>
    </form>
</#macro>