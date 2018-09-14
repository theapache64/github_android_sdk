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
    "repoOwnerName", // eg: theapache64
    "repoName", // eg: github_android_sdk
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
    "repoOwnerName", 
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

### Create Comment

```java
GitHubAPI.createComment(
    "repoOwnerName",
    "repoName", 
    1234, // issue number 
    "your comments goes here",
    new GitHubAPI.Callback<CreateCommentResponse>() {
        @Override
        public void onSuccess(CreateCommentResponse createCommentResponse) {
            System.out.println("Added comment");
        }

        @Override
        public void onError(Throwable t) {
            // Mostly network errors
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

