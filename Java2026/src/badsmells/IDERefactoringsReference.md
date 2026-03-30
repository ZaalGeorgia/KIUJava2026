# IDE Refactorings Reference for the Bad Smells Lab

This file lists practical refactorings from Eclipse JDT and IntelliJ IDEA that are useful across the code smell examples in this lab.

The goal is not to be exhaustive. The goal is to highlight the refactorings students are most likely to use while improving the examples in this package.

## Core Refactorings

<table>
  <thead>
    <tr>
      <th>Eclipse JDT</th>
      <th>IntelliJ IDEA</th>
    </tr>
  </thead>
  <tbody>
    <tr><td><code>Rename</code></td><td><code>Rename</code></td></tr>
    <tr><td><code>Move</code></td><td><code>Move</code></td></tr>
    <tr><td><code>Change Method Signature</code></td><td><code>Change Signature</code></td></tr>
    <tr><td><code>Extract Method</code></td><td><code>Extract Method</code></td></tr>
    <tr><td><code>Extract Local Variable</code></td><td><code>Extract Variable</code></td></tr>
    <tr><td><code>Extract Constant</code></td><td><code>Extract Constant</code></td></tr>
    <tr><td><code>Extract Class</code></td><td><code>Extract Delegate</code> / <code>Extract Method Object</code></td></tr>
    <tr><td><code>Introduce Parameter Object</code></td><td><code>Extract Parameter Object</code></td></tr>
    <tr><td><code>Encapsulate Field</code></td><td><code>Encapsulate Fields</code></td></tr>
    <tr><td><code>Inline Local Variable</code> / <code>Inline Constant</code> / <code>Inline Method</code></td><td><code>Inline</code></td></tr>
    <tr><td><code>Extract Interface</code></td><td><code>Extract Interface</code></td></tr>
    <tr><td><code>Extract Superclass</code></td><td><code>Extract Superclass</code></td></tr>
    <tr><td><code>Pull Up</code></td><td><code>Pull Members Up</code></td></tr>
    <tr><td><code>Push Down</code></td><td><code>Push Members Down</code></td></tr>
    <tr><td><code>Use Supertype Where Possible</code></td><td>Usually done through <code>Extract Interface</code> / <code>Extract Superclass</code> plus type replacement</td></tr>
    <tr><td><code>Generalize Declared Type</code></td><td>Usually done through <code>Change Signature</code> or manual type replacement after extraction</td></tr>
  </tbody>
</table>

## Refactorings by Smell

<table>
  <thead>
    <tr>
      <th>Smell</th>
      <th>Eclipse JDT</th>
      <th>IntelliJ IDEA</th>
    </tr>
  </thead>
  <tbody>
    <tr><td><code>Mysterious Name</code></td><td><code>Rename</code>, <code>Extract Method</code></td><td><code>Rename</code>, <code>Extract Method</code></td></tr>
    <tr><td><code>Duplicated Code</code></td><td><code>Extract Method</code>, <code>Move</code>, <code>Pull Up</code></td><td><code>Extract Method</code>, <code>Move</code>, <code>Pull Members Up</code></td></tr>
    <tr><td><code>Long Function</code></td><td><code>Extract Method</code>, <code>Extract Local Variable</code></td><td><code>Extract Method</code>, <code>Extract Variable</code></td></tr>
    <tr><td><code>Long Parameter List</code></td><td><code>Introduce Parameter Object</code>, <code>Change Method Signature</code></td><td><code>Extract Parameter Object</code>, <code>Change Signature</code></td></tr>
    <tr><td><code>Global Data</code></td><td><code>Encapsulate Field</code>, <code>Move</code>, <code>Extract Class</code></td><td><code>Encapsulate Fields</code>, <code>Move</code>, <code>Extract Delegate</code></td></tr>
    <tr><td><code>Mutable Data</code></td><td><code>Encapsulate Field</code>, <code>Move</code></td><td><code>Encapsulate Fields</code>, <code>Move</code></td></tr>
    <tr><td><code>Divergent Change</code></td><td><code>Extract Class</code>, <code>Move</code>, <code>Extract Method</code></td><td><code>Extract Delegate</code>, <code>Move</code>, <code>Extract Method</code></td></tr>
    <tr><td><code>Shotgun Surgery</code></td><td><code>Move</code>, <code>Extract Method</code>, <code>Pull Up</code></td><td><code>Move</code>, <code>Extract Method</code>, <code>Pull Members Up</code></td></tr>
    <tr><td><code>Feature Envy</code></td><td><code>Move</code>, <code>Extract Method</code></td><td><code>Move</code>, <code>Extract Method</code></td></tr>
    <tr><td><code>Data Clumps</code></td><td><code>Introduce Parameter Object</code>, <code>Extract Class</code></td><td><code>Extract Parameter Object</code>, <code>Extract Delegate</code></td></tr>
    <tr><td><code>Primitive Obsession</code></td><td><code>Extract Class</code>, <code>Extract Constant</code>, <code>Move</code></td><td><code>Extract Delegate</code>, <code>Extract Constant</code>, <code>Move</code></td></tr>
    <tr><td><code>Repeated Switches</code></td><td><code>Move</code>, <code>Extract Method</code>, <code>Extract Superclass</code></td><td><code>Move</code>, <code>Extract Method</code>, <code>Extract Superclass</code></td></tr>
    <tr><td><code>Loops</code></td><td><code>Extract Method</code>, <code>Rename</code></td><td><code>Extract Method</code>, <code>Rename</code></td></tr>
    <tr><td><code>Lazy Element</code></td><td><code>Inline</code>, <code>Move</code></td><td><code>Inline</code>, <code>Move</code></td></tr>
    <tr><td><code>Speculative Generality</code></td><td><code>Inline</code>, <code>Change Method Signature</code>, <code>Move</code></td><td><code>Inline</code>, <code>Change Signature</code>, <code>Move</code></td></tr>
    <tr><td><code>Temporary Field</code></td><td><code>Extract Class</code>, <code>Move</code>, <code>Encapsulate Field</code></td><td><code>Extract Delegate</code>, <code>Move</code>, <code>Encapsulate Fields</code></td></tr>
    <tr><td><code>Message Chains</code></td><td><code>Move</code>, <code>Extract Method</code></td><td><code>Move</code>, <code>Extract Method</code></td></tr>
    <tr><td><code>Middle Man</code></td><td><code>Inline</code>, <code>Move</code></td><td><code>Inline</code>, <code>Move</code></td></tr>
    <tr><td><code>Insider Trading</code></td><td><code>Move</code>, <code>Encapsulate Field</code></td><td><code>Move</code>, <code>Encapsulate Fields</code></td></tr>
    <tr><td><code>Large Class</code></td><td><code>Extract Class</code>, <code>Move</code>, <code>Extract Superclass</code></td><td><code>Extract Delegate</code>, <code>Move</code>, <code>Extract Superclass</code></td></tr>
    <tr><td><code>Alternative Classes with Different Interfaces</code></td><td><code>Extract Interface</code>, <code>Change Method Signature</code>, <code>Use Supertype Where Possible</code></td><td><code>Extract Interface</code>, <code>Change Signature</code>, <code>Extract Superclass</code></td></tr>
    <tr><td><code>Data Class</code></td><td><code>Move</code>, <code>Encapsulate Field</code>, <code>Extract Class</code></td><td><code>Move</code>, <code>Encapsulate Fields</code>, <code>Extract Delegate</code></td></tr>
    <tr><td><code>Refused Bequest</code></td><td><code>Push Down</code>, <code>Extract Superclass</code>, <code>Use Supertype Where Possible</code></td><td><code>Push Members Down</code>, <code>Extract Superclass</code>, <code>Pull Members Up</code></td></tr>
    <tr><td><code>Comments</code></td><td><code>Extract Method</code>, <code>Rename</code>, <code>Inline</code></td><td><code>Extract Method</code>, <code>Rename</code>, <code>Inline</code></td></tr>
  </tbody>
</table>

## Notes

- Eclipse and IntelliJ do not always use the same names for equivalent refactorings.
- Some refactorings are not exact one-to-one matches. Eclipse has an explicit <code>Extract Class</code>, while IntelliJ often reaches the same result through <code>Extract Delegate</code>, <code>Extract Method Object</code>, or a combination of smaller moves.
- <code>Use Supertype Where Possible</code> is explicitly named in Eclipse documentation. In IntelliJ IDEA the same result is usually achieved indirectly after extracting an interface or superclass.
- For smells like <code>Repeated Switches</code>, <code>Primitive Obsession</code>, and <code>Refused Bequest</code>, no single IDE command solves the full design problem. Students usually need several coordinated refactorings.

## Official Documentation

### Eclipse JDT

- [Refactor Actions](https://help.eclipse.org/latest/rtopic/org.eclipse.jdt.doc.user/reference/ref-menu-refactor.htm)
- [Extracting a New Method](https://help.eclipse.org/latest/rtopic/org.eclipse.jdt.doc.user/gettingStarted/qs-ExtractMethod.htm)
- [IJavaRefactorings API list](https://help.eclipse.org/latest/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/refactoring/IJavaRefactorings.html)
- [JDT refactor action constants](https://help.eclipse.org/latest/rtopic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/ui/actions/JdtActionConstants.html)

### IntelliJ IDEA

- [Rename refactorings](https://www.jetbrains.com/help/idea/rename-refactorings.html)
- [Move and copy refactorings](https://www.jetbrains.com/help/idea/move-refactorings.html)
- [Change Signature](https://www.jetbrains.com/help/idea/change-signature.html)
- [Extract Method](https://www.jetbrains.com/help/idea/extract-method.html)
- [Extract into class refactorings](https://www.jetbrains.com/help/idea/extract-into-class-refactorings.html)
- [Encapsulate Fields](https://www.jetbrains.com/help/idea/encapsulate-fields.html)
- [Inline](https://www.jetbrains.com/help/idea/inline.html)
- [Extract Interface](https://www.jetbrains.com/help/idea/extract-interface.html)
- [Extract Superclass](https://www.jetbrains.com/help/idea/extract-superclass.html)
- [Pull Members Up](https://www.jetbrains.com/help/idea/pull-members-up.html?keymap=primary_default_for_windows)
- [Push Members Down](https://www.jetbrains.com/help/idea/push-members-down.html)
