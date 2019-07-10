<#import "parts/common.ftl" as c>

<@c.page>
    <div class="container marketing">

        <div class="row featurette d-flex justify-content-center">
            <div class="col-md-7 order-md-2 d-flex flex-column justify-content-between">
                <h2 class="featurette-heading d-flex justify-content-between">
                    ${user.username}
                    <a href="/profile/settings">
                        <i class="fas fa-cog text-dark" style="font-size: 22px;"></i>
                    </a>
                </h2>
                <p class="lead d-flex">
                    <a href="/editor" class="nav-item nav-link text-light bg-dark rounded-0">Articles</a>
                    <a href="/editor/question" class="nav-item nav-link text-light bg-dark rounded-0 ml-2">Question</a>
                </p>
            </div>
            <div class="col-md-3 order-md-1">
                <img src="/img/${user.filename}" style="width: 250px; height: 250px;">
            </div>
        </div>

    </div>
</@c.page>