<#macro navEdit isQuestion=false isAdd=false>
    <nav class="nav nav-pills nav-fill">

        <a class="nav-item nav-link <#if !isQuestion && !isAdd>text-light bg-dark<#else>text-dark bg-light</#if> rounded-0" href="/editor">
            Articles
        </a>

        <a class="nav-item nav-link <#if !isQuestion && isAdd>text-light bg-dark<#else>text-dark bg-light</#if> rounded-0" href="/editor/add">
            Add article
        </a>
        <a class="nav-item nav-link <#if isQuestion && !isAdd>text-light bg-dark<#else>text-dark bg-light</#if> rounded-0" href="/editor/question">
            Questions
        </a>
        <a class="nav-item nav-link <#if isQuestion && isAdd>text-light bg-dark<#else>text-dark bg-light</#if> rounded-0" href="/editor/question/add">
            Add question
        </a>
    </nav>
</#macro>

