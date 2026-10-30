# 01Blog — 7-day plan

**Deadline:** Day 7 = Thu 5 Nov 2026 · **Effort:** ~8 focused hours/day
**Already done:** Step 0 (PostgreSQL in Docker) · Step 1A (Spring Boot app + first endpoint)

## Rules

1. **Scope is frozen.** Only the pages in `design/`. No bonus features.
2. **Stuck for more than 30 minutes?** Send Claude the error or a screenshot.
3. **Who writes what.** Setup code (security config, JWT, file upload config, interceptor, Dockerfiles): Claude gives it with explanations, you **type it** (no pasting) and explain it back. Feature code (entities, services, controllers, components): you write it from hints, Claude reviews.
4. **End of every day:** everything under "Done when" works → commit → answer the day's auditor questions out loud.
5. **Sleep 7 hours.** Tired code costs more time than it saves.

## Daily rhythm

| Block | Hours | What |
|---|---|---|
| Morning | 3h | Backend part of the day |
| Afternoon | 3h | Frontend part of the day (from Day 3) |
| Evening | 1.5–2h | Test, fix, commit, auditor questions |

Days 1–2 are backend all day.

---

## Day 1 — Fri 30 Oct · Users & register (backend)

**Learn:** Controller → Service → Repository layers, JPA entity, DTO, `@RequestBody`, validation, BCrypt, dependency injection.
**Read first:** https://spring.io/guides/gs/accessing-data-jpa

- [x] Commit Step 1A
- [ ] Delete the `restservice` practice code and the Customer demo in `BlogApplication`
- [ ] Feature packages: `user/` (later `post/`, `comment/` …)
- [ ] `User` entity: id, username (unique), email (unique), password (hash), role (USER/ADMIN), banned, createdAt
- [ ] `UserRepository`
- [ ] Add Spring Security dependency, temporary "everything open" config, BCrypt `PasswordEncoder`
- [ ] `POST /api/auth/register`: request DTO + validation → hashed password → 201 / 400 / 409
- [ ] Global error handler → clean JSON error messages

**Done when:** registering with curl creates a row (check in `psql`) with a hashed password; a duplicate username → 409; an empty email → 400.

**Auditor questions:** Why three layers? What is a DTO, and why not return the entity directly (hint: password)? Why hash passwords instead of encrypting them? What does `@Valid` do? What is dependency injection?

---

## Day 2 — Sat 31 Oct · Login, JWT, roles (backend)

- [ ] `POST /api/auth/login` → returns a JWT (username, role, expiry)
- [ ] JWT filter: reads `Authorization: Bearer …`, validates it, sets the logged-in user
- [ ] Security config: stateless; `/api/auth/**` public; `/api/admin/**` ADMIN only; everything else requires login
- [ ] Banned users can't log in
- [ ] `GET /api/users/me`
- [ ] CORS: allow `http://localhost:4200`
- [ ] First admin account created automatically at startup if none exists

**Done when:** login returns a token; `/api/users/me` works with the token and returns 401 without it; a USER calling `/api/admin/...` gets 403.

**Auditor questions:** What's inside a JWT, and can a user change their role in it? Stateless vs session? 401 vs 403? Where is the password checked? What is CORS, and why do we need it?

---

## Day 3 — Sun 1 Nov · Angular foundations + auth pages

**Learn (first 2h):** https://angular.dev/tutorials/learn-angular (components, templates, binding, routing, services)

- [ ] `ng new frontend` + Angular Material
- [ ] Routes: `/login`, `/register`, `/`, `/block/:username`, `/posts/:id`, `/admin` (placeholders)
- [ ] Navbar component (from `design/`)
- [ ] `AuthService`: register, login, logout, token storage, current user
- [ ] HTTP interceptor: adds the token to every request; on 401 → log out → `/login`
- [ ] Guards: logged-in only, admin only, guests only
- [ ] Login and Register pages (reactive forms + error messages)

**Done when:** register → login → land on Home; refreshing keeps you logged in; a USER opening `/admin` gets redirected; logout works.

**Auditor questions:** Component vs service? What does the interceptor do? What does a guard do, and why isn't it real security (the backend is)? What is an Observable, and what does `subscribe` do?

---

## Day 4 — Mon 2 Nov · Posts + media (full-stack)

**Backend**
- [ ] `Post` entity: id, author (`@ManyToOne` User), content, mediaUrl, mediaType, hidden, createdAt
- [ ] `POST /api/posts` (multipart: text + optional file) → file saved in `uploads/`, only image/video, size limit
- [ ] `GET /api/users/{username}/posts`, `GET /api/posts/{id}`
- [ ] `PUT` / `DELETE /api/posts/{id}`: **owner only** (403 otherwise); deleting also removes the file
- [ ] Serve media files over HTTP
- [ ] `PostResponse` DTO

**Frontend**
- [ ] `PostService`, post card component
- [ ] Block page: own (New post / Edit / Delete) and other user (posts only)
- [ ] Post form dialog (create + edit, media preview, remove media)
- [ ] Shared confirm dialog

**Done when:** create a post with an image and one with a video; edit; delete; another user can't edit or delete (403 from the API, buttons hidden in the UI).

**Auditor questions:** What does `@ManyToOne` mean? Where are files stored, and why not in the database? Show the code that stops me from deleting someone else's post. What is `multipart/form-data`?

---

## Day 5 — Tue 3 Nov · Subscriptions, feed, likes, comments

**Backend**
- [ ] Subscription (subscriber → target, unique pair): `POST` / `DELETE /api/users/{username}/subscribe`, no self-subscribe
- [ ] `GET /api/users` (students list), `GET /api/users/{username}` (profile + "am I subscribed")
- [ ] `GET /api/feed`: posts from people I follow, newest first, hidden posts excluded
- [ ] Like (user + post, unique): `POST` / `DELETE /api/posts/{id}/like`; like count + "liked by me" in `PostResponse`
- [ ] Comment (author, post, content, createdAt): `GET` / `POST /api/posts/{id}/comments`

**Frontend**
- [ ] Home: feed + students list + empty state
- [ ] Block page: Subscribe / Unsubscribe
- [ ] Post page: full post, like, comments (send → list refreshes)
- [ ] Like button on post cards

**Done when:** A subscribes to B → B's posts appear in A's feed; like/unlike updates the count; a comment appears after sending.

**Auditor questions:** Show your tables for likes and subscriptions. Why the unique constraint? How does the feed query work? How do you stop someone liking twice?

---

## Day 6 — Wed 4 Nov · Notifications, reports, admin

**Backend**
- [ ] Notification (recipient, post, read, createdAt): created for every subscriber when a post is published
- [ ] `GET /api/notifications`, mark one read / unread
- [ ] Report (reporter, reported user, reason, createdAt): `POST /api/users/{username}/report`
- [ ] Admin API (ADMIN only): list users / posts / reports; ban / unban; delete user (and their content); hide / unhide post; delete post; dismiss report

**Frontend**
- [ ] Bell + dropdown: unread count, mark read/unread, click → post
- [ ] Report dialog: reason → "Are you sure?" → send
- [ ] Admin page: Users / Posts / Reports tabs, every action goes through the confirm dialog

**Done when:** B posts → A gets a notification; A reports B → the admin sees it; the admin bans B → B can't log in; the admin hides a post → it disappears from feeds; a USER can't open `/admin` (UI) or call `/api/admin` (403).

**Auditor questions:** How are admin routes protected, on the backend AND the frontend? What happens to a deleted user's posts, comments and likes? Who can see reports?

---

## Day 7 — Thu 5 Nov · Docker, README, audit rehearsal

**Read first:** https://docs.docker.com/get-started/

- [ ] `backend/Dockerfile` (multi-stage: Maven build → Java runtime)
- [ ] `frontend/Dockerfile` (multi-stage: Node build → nginx)
- [ ] `docker-compose.yml`: db + backend + frontend, uploads volume, settings as environment variables
- [ ] `docker compose down -v && docker compose up --build` works from scratch
- [ ] README: what it is, technologies, how to run (Docker and dev mode), default admin account
- [ ] Full run-through of the checklist below with two browsers (one USER, one ADMIN)
- [ ] Rehearsal: explain every file you wrote out loud; answer all auditor questions from Days 1–6

**Auditor questions:** Dockerfile vs image vs container? What is a multi-stage build, and why use one? How do containers find each other?

> **Buffer:** Docker isn't required by the spec text. If you're behind on Day 7, use the day to finish features and keep Docker for PostgreSQL only.

---

## Final audit checklist (from the spec)

- [ ] Register, login, logout; passwords hashed in the database
- [ ] USER vs ADMIN access enforced on the backend and the frontend
- [ ] Block page lists a user's posts; subscribe / unsubscribe
- [ ] Notifications for new posts from subscriptions; mark read / unread
- [ ] Create / edit / delete posts with text + image or video; timestamp; media preview
- [ ] Likes and comments
- [ ] Report a user with a reason; confirmation before sending; reports visible only to admins
- [ ] Admin: view and manage users, posts, reports; ban / delete users; hide / remove posts
- [ ] Responsive UI with Angular Material
- [ ] PostgreSQL; media stored on the file system
- [ ] README: how to run + technologies used
- [ ] Clean Git history with meaningful commits
