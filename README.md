# ForceKeybind

Supports (Neo)Forge via Sinytra Connector

### Pre-built: https://github.com/mitw153/JSM-ForceKeybind/actions/runs/10911806502

## Usage
```javascript
// makes KeyBind work inside screens
ForceKeybind.set(true);

KeyBind.pressKeyBind("key.attack");
KeyBind.releaseKeyBind("key.attack");

// Disables force
ForceKeybind.set(false);
```
