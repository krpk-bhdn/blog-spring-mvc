<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>

    <main role="main" class="inner cover text-center">
        <h1 class="cover-heading">Welcome to Java<b>Evolve</b></h1>
        <p class="lead mt-3">Here you can share with your other knowledge, ask questions, find like-minded people, <br>take part in discussions, and get knowledge from others.</p>
        <#if !know>
            <p class="lead mt-3">
                <a href="/registration" class="btn btn-lg btn-dark">Join</a>
            </p>
        </#if>
    </main>

    <main role="main" class="mt-5">
        <div class="container marketing">

            <div class="row">
                <div class="col-lg-4 text-center">
                    <i class="fas fa-users fa-5x text-dark"></i>
                    <h2>Users</h2>
                    <p class="bg-dark text-light lead name-adm-mod">${countUser}</p>
                </div>
                <div class="col-lg-4 text-center">
                    <i class="fas fa-file-invoice fa-5x text-dark"></i>
                    <h2>Articles</h2>
                    <p class="bg-dark text-light lead name-adm-mod">${countArticle}</p>
                </div>
                <div class="col-lg-4 text-center">
                    <i class="fas fa-question fa-5x text-dark"></i>
                    <h2>Questions</h2>
                    <p class="bg-dark text-light lead name-adm-mod">${countQuestion}</p>
                </div>
            </div>

        </div>

    </main>

</@c.page>