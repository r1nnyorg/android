import webdriverio from 'webdriverio'

const opts = {
  path: '/wd/hub',
  hostname: '0.0.0.0',
  port: 4723,
  capabilities: {
    platformName: 'Android',
    automationName: 'UiAutomator2',
    app: 'ApiDemos-debug.apk'
  }
}

const client = await webdriverio.remote(opts)
await client.deleteSession()
