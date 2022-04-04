import webdriverio from 'webdriverio'
import {promises as fs} from 'fs'

const opts = {
  path: '/wd/hub',
  hostname: '0.0.0.0',
  port: 4723,
  capabilities: {
    platformName: 'Android',
    automationName: 'UiAutomator2',
    app: 'cashmagnetNew.apk'
  }
}

const client = await webdriverio.remote(opts)
await new globalThis.Promise(_ => globalThis.setTimeout(_, 1000 * 15))
await fs.writeFile('haha.png', await client.takeScreenshot(), 'base64')
await client.deleteSession()
