---
name: Academic Ink
colors:
  surface: '#f8f9ff'
  surface-dim: '#cbdbf5'
  surface-bright: '#f8f9ff'
  surface-container-lowest: '#ffffff'
  surface-container-low: '#eff4ff'
  surface-container: '#e5eeff'
  surface-container-high: '#dce9ff'
  surface-container-highest: '#d3e4fe'
  on-surface: '#0b1c30'
  on-surface-variant: '#464555'
  inverse-surface: '#213145'
  inverse-on-surface: '#eaf1ff'
  outline: '#777587'
  outline-variant: '#c7c4d8'
  surface-tint: '#4d44e3'
  primary: '#3525cd'
  on-primary: '#ffffff'
  primary-container: '#4f46e5'
  on-primary-container: '#dad7ff'
  inverse-primary: '#c3c0ff'
  secondary: '#006591'
  on-secondary: '#ffffff'
  secondary-container: '#39b8fd'
  on-secondary-container: '#004666'
  tertiary: '#3130c0'
  on-tertiary: '#ffffff'
  tertiary-container: '#4b4dd8'
  on-tertiary-container: '#d9d8ff'
  error: '#ba1a1a'
  on-error: '#ffffff'
  error-container: '#ffdad6'
  on-error-container: '#93000a'
  primary-fixed: '#e2dfff'
  primary-fixed-dim: '#c3c0ff'
  on-primary-fixed: '#0f0069'
  on-primary-fixed-variant: '#3323cc'
  secondary-fixed: '#c9e6ff'
  secondary-fixed-dim: '#89ceff'
  on-secondary-fixed: '#001e2f'
  on-secondary-fixed-variant: '#004c6e'
  tertiary-fixed: '#e1e0ff'
  tertiary-fixed-dim: '#c0c1ff'
  on-tertiary-fixed: '#07006c'
  on-tertiary-fixed-variant: '#2f2ebe'
  background: '#f8f9ff'
  on-background: '#0b1c30'
  surface-variant: '#d3e4fe'
typography:
  display-lg:
    fontFamily: Inter
    fontSize: 48px
    fontWeight: '700'
    lineHeight: 56px
    letterSpacing: -0.02em
  display-sm:
    fontFamily: Inter
    fontSize: 36px
    fontWeight: '700'
    lineHeight: 44px
    letterSpacing: -0.02em
  headline-lg:
    fontFamily: Inter
    fontSize: 32px
    fontWeight: '600'
    lineHeight: 40px
    letterSpacing: -0.01em
  headline-lg-mobile:
    fontFamily: Inter
    fontSize: 26px
    fontWeight: '600'
    lineHeight: 34px
    letterSpacing: -0.01em
  headline-md:
    fontFamily: Inter
    fontSize: 24px
    fontWeight: '600'
    lineHeight: 32px
    letterSpacing: -0.005em
  headline-sm:
    fontFamily: Inter
    fontSize: 20px
    fontWeight: '600'
    lineHeight: 28px
  title-md:
    fontFamily: Inter
    fontSize: 16px
    fontWeight: '600'
    lineHeight: 24px
  body-lg:
    fontFamily: Inter
    fontSize: 18px
    fontWeight: '400'
    lineHeight: 30px
  body-md:
    fontFamily: Inter
    fontSize: 15px
    fontWeight: '400'
    lineHeight: 24px
  body-sm:
    fontFamily: Inter
    fontSize: 13px
    fontWeight: '400'
    lineHeight: 20px
  label-lg:
    fontFamily: Inter
    fontSize: 14px
    fontWeight: '500'
    lineHeight: 20px
  label-md:
    fontFamily: Inter
    fontSize: 12px
    fontWeight: '500'
    lineHeight: 16px
    letterSpacing: 0.01em
  label-sm:
    fontFamily: Inter
    fontSize: 11px
    fontWeight: '600'
    lineHeight: 16px
    letterSpacing: 0.03em
rounded:
  sm: 0.25rem
  DEFAULT: 0.5rem
  md: 0.75rem
  lg: 1rem
  xl: 1.5rem
  full: 9999px
spacing:
  gutter: 1.5rem
  gutter-sm: 1rem
  gutter-lg: 2rem
  margin: 2rem
  margin-mobile: 1rem
  margin-desktop: 3rem
  space-xs: 0.25rem
  space-sm: 0.5rem
  space-md: 1rem
  space-lg: 1.5rem
  space-xl: 2.5rem
---

## Brand & Style

The design system embodies a modern, calm, and distraction-free academic environment tailored for students, educators, and young researchers. Its primary goal is to foster intellectual focus, low cognitive fatigue, and effortless readability.

Drawing from modern Material Design 3 and refined minimalism, the aesthetic pairs the deliberate structure of editorial layouts with the utility of modern web applications. The visual tone is scholarly yet fresh, avoiding sterile corporate rigidity in favor of an inviting, structured digital workspace. Interactions feel light, crisp, and predictable, ensuring that student writing and knowledge synthesis remain the focal point.

## Colors

The palette is anchored by an indigo primary tone (`#4F46E5`) representing intellect, clarity, and purpose. It is supported by a sky secondary tone (`#0EA5E9`) for active highlights and secondary metrics, alongside a softer indigo tertiary (`#6366F1`) for interactive tags and contextual accents.

The background structure uses a dual-tone neutral canvas:
- Outer canvas and body background: `#F8FAFC` (Slate 50)
- Surface container subtle / structural borders: `#F1F5F9` (Slate 100)
- Elevated surfaces and card containers: `#FFFFFF` (Pure White)
- Primary high-emphasis text: `#0F172A` (Slate 900)
- Secondary medium-emphasis text: `#475569` (Slate 600)
- Low-emphasis borders, dividers, and disabled states: `#E2E8F0` (Slate 200)

Ensure high contrast ratios (minimum 4.5:1 for body copy and 3:1 for large display elements) are maintained across all interactive surfaces to uphold strict accessibility standards.

## Typography

Typography relies uniformly on **Inter** across display, editorial body, and utility levels, adhering strictly to Material Design 3 scale conventions.

- **Long-form reading:** Editorial article text is styled with `body-lg` (18px, 30px line-height) to maintain an optimal reading cadence of 65–75 characters per line.
- **Micro-copy & Metadata:** Authorship, timestamps, and tags utilize `label-md` and `label-sm` with slightly boosted tracking (`0.01em` to `0.03em`) for immediate scannability against neutral backgrounds.
- **Hierarchy:** Maintain strict semantic pairings; `headline-lg` steps down to `headline-lg-mobile` under viewport widths of 768px to avoid awkward word breaks on compact viewports.

## Layout & Spacing

The layout is built around a standard 12-column responsive fluid grid on desktop (`> 1024px`) with a maximum page content width of `1200px` centered on the `#F8FAFC` base. Reading views are constrained to a specialized 8-column reading column (`max-width: 760px`) to prevent visual strain.

- **Desktop (1024px+):** 12 columns, `2rem` gutters, `3rem` outer margins.
- **Tablet (600px - 1023px):** 8 columns, `1.5rem` gutters, `2rem` outer margins.
- **Mobile (< 600px):** 4 columns, `1rem` gutters, `1rem` outer canvas margins.

Rhythm is based on an incremental 4px/8px baseline grid. Gaps between related content blocks in cards strictly adhere to `space-sm` (8px) and `space-md` (16px), whereas section splits leverage `space-xl` (40px).

## Elevation & Depth

Visual depth follows Material Design 3 surface-elevation principles modified for subtle modern contrast on light slate backgrounds:

- **Level 0 (Surface Base):** `#F8FAFC`. Zero elevation, pure flat canvas for backgrounds and structural sidebars.
- **Level 1 (Card Resting / Outlined Containers):** `#FFFFFF` with a hairline border `1px solid #E2E8F0` accompanied by an ultra-soft shadow: `0 1px 3px 0 rgba(15, 23, 42, 0.04), 0 1px 2px -1px rgba(15, 23, 42, 0.02)`.
- **Level 2 (Interactive Hover / Floating Panels):** `#FFFFFF` elevated using `0 4px 6px -1px rgba(15, 23, 42, 0.07), 0 2px 4px -2px rgba(15, 23, 42, 0.04)`.
- **Level 3 (Dropdowns / Menus / Popovers):** `0 10px 15px -3px rgba(15, 23, 42, 0.08), 0 4px 6px -4px rgba(15, 23, 42, 0.03)`.
- **Level 4 (Modal Dialogs):** Centered overlays on `#0F172A` at 40% opacity, elevated with `0 20px 25px -5px rgba(15, 23, 42, 0.1), 0 8px 10px -6px rgba(15, 23, 42, 0.04)`.

Shadows are tinted strictly with the slate neutral `#0F172A` rather than pure black, ensuring an organic ambient blend with the `#F8FAFC` foundation.

## Shapes

The design system standardizes on a balanced curved language:

- **Cards and Structured Containers:** Fixed at `12px` (`0.75rem`), balancing modern warmth with compact organization.
- **Interactive Inputs and Buttons:** Standardized at `8px` (`0.5rem`) to retain structural alignment within forms and toolbars.
- **Chips, Badges, and Avatars:** Fully circular/pill-shaped (`9999px`) to create clear visual contrast against structural card geometry.
- **Dialogs & Floating Sheets:** Styled with `16px` (`1rem`) border radius.

## Components

### Buttons
- **Filled (Primary):** Background `#4F46E5`, foreground `#FFFFFF`, border-radius `8px`, height `40px` (desktop) / `44px` (mobile touch target). Hover state: `#4338CA`. Active state: `#3730A3`.
- **Tonal (Secondary):** Background `#EEF2FF`, foreground `#4F46E5`, border-radius `8px`. Hover state: `#E0E7FF`.
- **Outlined:** Border `1px solid #E2E8F0`, background transparent, foreground `#0F172A`. Hover: background `#F1F5F9`.

### Cards
- **Article / Feed Card:** Background `#FFFFFF`, border-radius `12px`, border `1px solid #E2E8F0`, subtle Level 1 shadow. Internal padding: `1.5rem` (`24px`). Hover transition: Level 2 elevation with a `-2px` transform on the Y-axis.

### Input Fields
- **Text Box:** Background `#FFFFFF`, border `1px solid #CBD5E1`, border-radius `8px`, height `44px`, padding `0 14px`. Typography `body-md`. Focus ring: `2px solid #4F46E5` with `2px` offset. Placeholder color: `#94A3B8`.

### Lists & Activity Feeds
- Transparent containers with items separated by `#F1F5F9` dividers. Hover highlights invoke `#F8FAFC` background fills with an immediate `150ms` transition.

