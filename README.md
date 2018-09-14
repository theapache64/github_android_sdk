# github_android_sdk
An android SDK for github (beta)

### Install

```groovy
    compile 'com.theapache64.github_android_sdk:github_android_sdk:1.0.0'
```

### Init

```
    GitHubAPI.init("YOUR_GITHUB_ACCESS_TOKEN");
```

### Create Issue

```java
GitHubAPI.createIssue(
    "userName",
    "repoName",
    "Issue's Title",
    "bodyGoesHere",
    new GitHubAPI.Callback<CreateIssueResponse>() {
        @Override
        public void onSuccess(CreateIssueResponse createIssueResponse) {
            System.out.println("New issue added");
        }

        @Override
        public void onError(Throwable t) {
            // Mostly network errors
        }
    });
```

### List Issues

```java
GitHubAPI.listIssues(
    "userName", 
    "repoName", 
    "Issue's Title",
    new GitHubAPI.Callback<List<ListIssuesResponse.Issue>>() {
        @Override
        public void onSuccess(List<ListIssuesResponse.Issue> issues) {
            // Manager result here
        }

        @Override
        public void onError(Throwable t) {
            // Mostly network errros
        }
    });

```


the rest is self explanatory.

### Supported operations

- Create Issue
- List Issues
- Create Comment

### TODO

- All GitHub v3 API Operations

