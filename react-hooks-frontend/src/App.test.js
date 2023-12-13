import { render, screen } from '@testing-library/react';
import TestRenderer from "react-test-renderer";
import App from './App';

it("Renders the App correctly", () => {
  const tree = TestRenderer.create(<App />).toJSON();
  expect(tree).toMatchSnapshot();
});
