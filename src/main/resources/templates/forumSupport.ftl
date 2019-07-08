<#import "parts/common.ftl" as c>

<@c.page>


    <nav class="nav nav-pills nav-fill">
        <a class="nav-item nav-link text-dark bg-light rounded-0" href="/forum">
            Discussions
        </a>
        <a class="nav-item nav-link text-light bg-dark rounded-0" href="/forum/support">
            Supports
        </a>
    </nav>

    <div class="d-flex justify-content-center">
        <form class="form-inline my-lg-3" action="/forum/support" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input class="form-control mr-sm-2" style="width: 40vh;" type="search" placeholder="Search" aria-label="Search" name="title">
            <button class="btn btn-dark my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>

    <div class="media mt-3">
        <div class="media-body">
            <#list supports as support>
                <div class="media mt-1 ml-5">
                    <a class="mr-3" href="/forum/${support.id}">
                        <div class="media-body">
                            <h5 class="mt-0">${support.title}</h5>
                        </div>
                    </a>
                </div>
            </#list>
        </div>
    </div>

</@c.page>

