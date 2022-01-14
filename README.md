A sample project for demonstrating Google Cloud Build with Cloud Run 

There are two pipelines here:

1. cloudbuild-pr.yaml - this pipeline gets triggered when a PR is created against this project. Once all the tests are completed, a [revision tag](https://cloud.google.com/run/docs/rollouts-rollbacks-traffic-migration#tags) with name "preview-PR#" is created handling no traffic. This enables the PR branch to be tested using an endpoint which looks like this "https://preview-13---originalurl"

2. cloudbuild.yaml - this pipeline gets triggered when a PR is merged to the "main" branch. The code is deployed to Google Cloud Run.
