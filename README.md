# springboot-search-service

Minimal Spring Boot service used to prototype automated OpenAPI spec migration.

## Run locally

```
./mvnw spring-boot:run
```

`GET /search?query=<text>` searches an in-memory list of records.
springdoc generates the OpenAPI spec at `/v3/api-docs`.

## CI/CD

`.github/workflows/spec-sync.yml` runs on every push to `main`: it starts
the app, fetches `/v3/api-docs`, diffs it against the latest version
stored in `shared-specs-repo`, and opens a PR there with the new/updated
spec. See that repo's README for the versioning rules.

Requires a repo secret `SHARED_REPO_PAT` — a GitHub token with write
access to `shared-specs-repo` (contents + pull requests), used as
`GH_TOKEN` for `gh pr create` and to push the update branch.
