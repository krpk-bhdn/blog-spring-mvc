<#import "parts/common.ftl" as c>

<@c.page>

    <div class="album py-5">
        <div class="container">

            <div class="row">
                <#list articles?sort_by("publicationDate")?reverse as article>
                    <div class="col-md-4">

                        <div class="card mb-4 shadow-sm">
                            <img src="/img/${article.filename}" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title">${article.title[0..*50]}</h5>
                                <div class="d-flex justify-content-between align-items-center">
                                    <small class="text-muted">${article.formattedPublicationDate()}</small>
                                </div>
                                <a href="/article/${article.id}" class="stretched-link" style="outline: none;"></a>
                            </div>
                        </div>

                    </div>
                </#list>
            </div>
        </div>
    </div>

</@c.page>